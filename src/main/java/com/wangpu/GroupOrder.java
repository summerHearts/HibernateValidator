package com.wangpu;

import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory;

import javax.validation.GroupSequence;

/**
 * Created by Kenvin on 2017/10/15.
 */
@GroupSequence({GroupA.class, GroupB.class, XMLStreamReaderFactory.Default.class})
public interface GroupOrder {
}