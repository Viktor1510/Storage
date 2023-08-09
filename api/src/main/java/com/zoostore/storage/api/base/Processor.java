package com.zoostore.storage.api.base;

public interface Processor  <I extends OperationRequest, R extends OperationResult> {
    R process(I input );
}
