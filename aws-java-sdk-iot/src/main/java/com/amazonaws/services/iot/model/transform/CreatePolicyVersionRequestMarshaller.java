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
package com.amazonaws.services.iot.model.transform;

import static com.amazonaws.util.StringUtils.UTF8;
import static com.amazonaws.util.StringUtils.COMMA_SEPARATOR;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.regex.Pattern;

import com.amazonaws.AmazonClientException;
import com.amazonaws.Request;
import com.amazonaws.DefaultRequest;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.iot.model.*;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.BinaryUtils;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.IdempotentUtils;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.SdkHttpUtils;
import com.amazonaws.protocol.json.*;

/**
 * CreatePolicyVersionRequest Marshaller
 */
public class CreatePolicyVersionRequestMarshaller
        implements
        Marshaller<Request<CreatePolicyVersionRequest>, CreatePolicyVersionRequest> {

    private final SdkJsonProtocolFactory protocolFactory;

    public CreatePolicyVersionRequestMarshaller(
            SdkJsonProtocolFactory protocolFactory) {
        this.protocolFactory = protocolFactory;
    }

    public Request<CreatePolicyVersionRequest> marshall(
            CreatePolicyVersionRequest createPolicyVersionRequest) {

        if (createPolicyVersionRequest == null) {
            throw new AmazonClientException(
                    "Invalid argument passed to marshall(...)");
        }

        Request<CreatePolicyVersionRequest> request = new DefaultRequest<CreatePolicyVersionRequest>(
                createPolicyVersionRequest, "AWSIot");

        request.setHttpMethod(HttpMethodName.POST);

        String uriResourcePath = "/policies/{policyName}/version";

        uriResourcePath = uriResourcePath
                .replace(
                        "{policyName}",
                        (createPolicyVersionRequest.getPolicyName() != null) ? SdkHttpUtils
                                .urlEncode(StringUtils
                                        .fromString(createPolicyVersionRequest
                                                .getPolicyName()), false) : "");
        request.setResourcePath(uriResourcePath);

        if (createPolicyVersionRequest.getSetAsDefault() != null) {
            request.addParameter("setAsDefault", StringUtils
                    .fromBoolean(createPolicyVersionRequest.getSetAsDefault()));
        }

        try {
            final StructuredJsonGenerator jsonGenerator = protocolFactory
                    .createGenerator();
            jsonGenerator.writeStartObject();

            if (createPolicyVersionRequest.getPolicyDocument() != null) {
                jsonGenerator.writeFieldName("policyDocument").writeValue(
                        createPolicyVersionRequest.getPolicyDocument());
            }

            jsonGenerator.writeEndObject();

            byte[] content = jsonGenerator.getBytes();
            request.setContent(new ByteArrayInputStream(content));
            request.addHeader("Content-Length",
                    Integer.toString(content.length));
            if (!request.getHeaders().containsKey("Content-Type")) {
                request.addHeader("Content-Type",
                        protocolFactory.getContentType());
            }
        } catch (Throwable t) {
            throw new AmazonClientException(
                    "Unable to marshall request to JSON: " + t.getMessage(), t);
        }

        return request;
    }

}