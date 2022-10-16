package com.me.cloudnative.extractor;

/*public class JsonExtractor<T extends Mono<JsonObject>,M extends ReactiveHttpInputMessage> implements BodyExtractor {
    private static final Logger LOG = Logger.getLogger(JsonExtractor.class.getName());

    @Override
    public Object extract(ReactiveHttpInputMessage inputMessage, Context context) {
        return Mono.<JsonObject>create(
             sink->{
                 inputMessage.getBody().subscribe(new Subscriber() {
                     @Override
                     public void onSubscribe(Subscription s) {
                         s.request(1);
                     }

                     @Override
                     public void onNext(Object o) {
                         DataBuffer t=(DataBuffer) o;

                         //sink.success(new JsonObject(t));
                     }

                     @Override
                     public void onError(Throwable throwable) {
                         LOG.log(Level.SEVERE, "jsonobjectbodyextractor onerror", "thrwbl");
                     }

                     @Override
                     public void onComplete() {
                         LOG.log(Level.INFO, "jsonobjectbodyextractor oncomplete");
                     }
                 });
             }
        );
    }
}*/
