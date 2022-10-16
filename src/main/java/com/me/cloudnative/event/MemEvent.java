package com.me.cloudnative.event;

import com.me.cloudnative.domain.NativeMember;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@RequiredArgsConstructor
@Data
public class MemEvent {
    private final NativeMember nativeMember;
    private final Date date;

}
