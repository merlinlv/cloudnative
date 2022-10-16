package com.me.cloudnative.component;

import com.me.cloudnative.domain.NativeMember;
import com.me.cloudnative.event.MemEvent;
import com.me.cloudnative.mapper.NativeMemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.time.Duration;
import java.util.Date;
import java.util.stream.Stream;

@Component
@RequiredArgsConstructor

public class RouterHandlers {

    private final NativeMemberMapper nativeMemberRepository;

    public Mono<ServerResponse> getAll(ServerRequest serverRequest) {
        return ServerResponse.ok().bodyValue(nativeMemberRepository.findAll());
    }

    public Mono<ServerResponse> getById(ServerRequest serverRequest) {
        String memId=serverRequest.pathVariable("id");
        return ServerResponse.ok().bodyValue(nativeMemberRepository.fingById(memId));
    }

    public Mono<ServerResponse> getEvent(ServerRequest serverRequest) {
        String memId=serverRequest.pathVariable("id");
        return ServerResponse.ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(Flux.just(nativeMemberRepository.fingById(memId))
                .flatMap(
                            mem->{
                                Flux<Long> interval=Flux.interval(Duration.ofSeconds(2));
                                Flux<MemEvent> memEventFlux=Flux.fromStream(
                                        Stream.generate(
                                                ()->new MemEvent(mem,new Date()))
                                );
                                return Flux.zip(interval,memEventFlux)
                                        .map(Tuple2::getT2);
                            }),MemEvent.class
          );
    }
    @Transactional
    public Mono<ServerResponse> addMem(ServerRequest serverRequest)  {
        Mono<NativeMember>  tt= serverRequest.bodyToMono(NativeMember.class);
        return tt.flatMap(u->ServerResponse.status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(nativeMemberRepository.addMem(u.getMemName(),u.getMemNo(),u.getMemCell(),u.getMemAge())));
    }

       /* NativeMember mono = null;
        AtomicReference<String> str= new AtomicReference<>("");
        try {
            ServerHttpRequest t = serverRequest.exchange().getRequest();
            Flux<DataBuffer> body = t.getBody();
            body.subscribe(buffer->{
                CharBuffer bf= StandardCharsets.UTF_8.decode(buffer.asByteBuffer());
                DataBufferUtils.release(buffer);
                str.set(bf.toString());
            });
          //  mono = serverRequest.bodyToMono(NativeMember.class).toFuture().get(50, TimeUnit.SECONDS);
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            String tt=str.get();
            System.out.println(tt);
            return ServerResponse.accepted().body(nativeMemberRepository.addMem(mono), NativeMember.class);
        }
    }*/
}
