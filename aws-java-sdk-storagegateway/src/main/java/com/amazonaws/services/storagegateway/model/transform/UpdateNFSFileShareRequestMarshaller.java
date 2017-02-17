/*
 * Copyright 2012-2017 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file except in compliance with
 * the License. A copy of the License is located at
 * 
 * http://aws.amazon.com/apache2.0
 * 
 * or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 */
package com.amazonaws.services.storagegateway.model.transform;

import java.io.ByteArrayInputStream;

import javax.annotation.Generated;

import com.amazonaws.SdkClientException;
import com.amazonaws.Request;
import com.amazonaws.DefaultRequest;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.storagegateway.model.*;
import com.amazonaws.transform.Marshaller;

import com.amazonaws.protocol.json.*;

/**
 * UpdateNFSFileShareRequest Marshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class UpdateNFSFileShareRequestMarshaller implements Marshaller<Request<UpdateNFSFileShareRequest>, UpdateNFSFileShareRequest> {

    private final SdkJsonMarshallerFactory protocolFactory;

    public UpdateNFSFileShareRequestMarshaller(SdkJsonMarshallerFactory protocolFactory) {
        this.protocolFactory = protocolFactory;
    }

    public Request<UpdateNFSFileShareRequest> marshall(UpdateNFSFileShareRequest updateNFSFileShareRequest) {

        if (updateNFSFileShareRequest == null) {
            throw new SdkClientException("Invalid argument passed to marshall(...)");
        }

        Request<UpdateNFSFileShareRequest> request = new DefaultRequest<UpdateNFSFileShareRequest>(updateNFSFileShareRequest, "AWSStorageGateway");
        request.addHeader("X-Amz-Target", "StorageGateway_20130630.UpdateNFSFileShare");

        request.setHttpMethod(HttpMethodName.POST);

        request.setResourcePath("");

        try {
            final StructuredJsonGenerator jsonGenerator = protocolFactory.createGenerator();

            jsonGenerator.writeStartObject();

            if (updateNFSFileShareRequest.getFileShareARN() != null) {
                jsonGenerator.writeFieldName("FileShareARN").writeValue(updateNFSFileShareRequest.getFileShareARN());
            }
            if (updateNFSFileShareRequest.getKMSEncrypted() != null) {
                jsonGenerator.writeFieldName("KMSEncrypted").writeValue(updateNFSFileShareRequest.getKMSEncrypted());
            }
            if (updateNFSFileShareRequest.getKMSKey() != null) {
                jsonGenerator.writeFieldName("KMSKey").writeValue(updateNFSFileShareRequest.getKMSKey());
            }
            if (updateNFSFileShareRequest.getNFSFileShareDefaults() != null) {
                jsonGenerator.writeFieldName("NFSFileShareDefaults");
                NFSFileShareDefaultsJsonMarshaller.getInstance().marshall(updateNFSFileShareRequest.getNFSFileShareDefaults(), jsonGenerator);
            }
            if (updateNFSFileShareRequest.getDefaultStorageClass() != null) {
                jsonGenerator.writeFieldName("DefaultStorageClass").writeValue(updateNFSFileShareRequest.getDefaultStorageClass());
            }

            com.amazonaws.internal.SdkInternalList<String> clientListList = (com.amazonaws.internal.SdkInternalList<String>) updateNFSFileShareRequest
                    .getClientList();
            if (!clientListList.isEmpty() || !clientListList.isAutoConstruct()) {
                jsonGenerator.writeFieldName("ClientList");
                jsonGenerator.writeStartArray();
                for (String clientListListValue : clientListList) {
                    if (clientListListValue != null) {
                        jsonGenerator.writeValue(clientListListValue);
                    }
                }
                jsonGenerator.writeEndArray();
            }

            jsonGenerator.writeEndObject();

            byte[] content = jsonGenerator.getBytes();
            request.setContent(new ByteArrayInputStream(content));
            request.addHeader("Content-Length", Integer.toString(content.length));
            request.addHeader("Content-Type", protocolFactory.getContentType());
        } catch (Throwable t) {
            throw new SdkClientException("Unable to marshall request to JSON: " + t.getMessage(), t);
        }

        return request;
    }

}