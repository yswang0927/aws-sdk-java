/*
 * Copyright 2011-2016 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"). You may not
 * use this file except in compliance with the License. A copy of the License is
 * located at
 * 
 * http://aws.amazon.com/apache2.0
 * 
 * or in the "license" file accompanying this file. This file is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package com.amazonaws.services.codepipeline.model.transform;

import java.io.ByteArrayInputStream;
import java.util.Collections;
import java.util.Map;
import java.util.List;
import java.util.regex.Pattern;

import com.amazonaws.AmazonClientException;
import com.amazonaws.Request;
import com.amazonaws.DefaultRequest;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.codepipeline.model.*;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.BinaryUtils;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.IdempotentUtils;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.protocol.json.*;

/**
 * CreateCustomActionTypeRequest Marshaller
 */
public class CreateCustomActionTypeRequestMarshaller
        implements
        Marshaller<Request<CreateCustomActionTypeRequest>, CreateCustomActionTypeRequest> {

    private final SdkJsonProtocolFactory protocolFactory;

    public CreateCustomActionTypeRequestMarshaller(
            SdkJsonProtocolFactory protocolFactory) {
        this.protocolFactory = protocolFactory;
    }

    public Request<CreateCustomActionTypeRequest> marshall(
            CreateCustomActionTypeRequest createCustomActionTypeRequest) {

        if (createCustomActionTypeRequest == null) {
            throw new AmazonClientException(
                    "Invalid argument passed to marshall(...)");
        }

        Request<CreateCustomActionTypeRequest> request = new DefaultRequest<CreateCustomActionTypeRequest>(
                createCustomActionTypeRequest, "AWSCodePipeline");
        request.addHeader("X-Amz-Target",
                "CodePipeline_20150709.CreateCustomActionType");

        request.setHttpMethod(HttpMethodName.POST);

        request.setResourcePath("");

        try {
            final StructuredJsonGenerator jsonGenerator = protocolFactory
                    .createGenerator();

            jsonGenerator.writeStartObject();

            if (createCustomActionTypeRequest.getCategory() != null) {
                jsonGenerator.writeFieldName("category").writeValue(
                        createCustomActionTypeRequest.getCategory());
            }
            if (createCustomActionTypeRequest.getProvider() != null) {
                jsonGenerator.writeFieldName("provider").writeValue(
                        createCustomActionTypeRequest.getProvider());
            }
            if (createCustomActionTypeRequest.getVersion() != null) {
                jsonGenerator.writeFieldName("version").writeValue(
                        createCustomActionTypeRequest.getVersion());
            }
            if (createCustomActionTypeRequest.getSettings() != null) {
                jsonGenerator.writeFieldName("settings");
                ActionTypeSettingsJsonMarshaller.getInstance().marshall(
                        createCustomActionTypeRequest.getSettings(),
                        jsonGenerator);
            }

            java.util.List<ActionConfigurationProperty> configurationPropertiesList = createCustomActionTypeRequest
                    .getConfigurationProperties();
            if (configurationPropertiesList != null) {
                jsonGenerator.writeFieldName("configurationProperties");
                jsonGenerator.writeStartArray();
                for (ActionConfigurationProperty configurationPropertiesListValue : configurationPropertiesList) {
                    if (configurationPropertiesListValue != null) {

                        ActionConfigurationPropertyJsonMarshaller.getInstance()
                                .marshall(configurationPropertiesListValue,
                                        jsonGenerator);
                    }
                }
                jsonGenerator.writeEndArray();
            }
            if (createCustomActionTypeRequest.getInputArtifactDetails() != null) {
                jsonGenerator.writeFieldName("inputArtifactDetails");
                ArtifactDetailsJsonMarshaller
                        .getInstance()
                        .marshall(
                                createCustomActionTypeRequest
                                        .getInputArtifactDetails(),
                                jsonGenerator);
            }
            if (createCustomActionTypeRequest.getOutputArtifactDetails() != null) {
                jsonGenerator.writeFieldName("outputArtifactDetails");
                ArtifactDetailsJsonMarshaller
                        .getInstance()
                        .marshall(
                                createCustomActionTypeRequest
                                        .getOutputArtifactDetails(),
                                jsonGenerator);
            }

            jsonGenerator.writeEndObject();

            byte[] content = jsonGenerator.getBytes();
            request.setContent(new ByteArrayInputStream(content));
            request.addHeader("Content-Length",
                    Integer.toString(content.length));
            request.addHeader("Content-Type", protocolFactory.getContentType());
        } catch (Throwable t) {
            throw new AmazonClientException(
                    "Unable to marshall request to JSON: " + t.getMessage(), t);
        }

        return request;
    }

}