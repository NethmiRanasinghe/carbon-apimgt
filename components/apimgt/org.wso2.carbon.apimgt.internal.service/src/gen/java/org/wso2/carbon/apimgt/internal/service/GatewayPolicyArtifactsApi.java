package org.wso2.carbon.apimgt.internal.service;

import org.wso2.carbon.apimgt.internal.service.dto.ErrorDTO;
import org.wso2.carbon.apimgt.internal.service.GatewayPolicyArtifactsApiService;
import org.wso2.carbon.apimgt.internal.service.impl.GatewayPolicyArtifactsApiServiceImpl;
import org.wso2.carbon.apimgt.api.APIManagementException;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.inject.Inject;

import io.swagger.annotations.*;
import java.io.InputStream;

import org.apache.cxf.jaxrs.ext.MessageContext;
import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.apache.cxf.jaxrs.ext.multipart.Multipart;

import java.util.Map;
import java.util.List;
import javax.validation.constraints.*;
@Path("/gateway-policy-artifacts")

@Api(description = "the gateway-policy-artifacts API")




public class GatewayPolicyArtifactsApi  {

  @Context MessageContext securityContext;

GatewayPolicyArtifactsApiService delegate = new GatewayPolicyArtifactsApiServiceImpl();


    @GET
    
    
    @Produces({ "application/json" })
    @ApiOperation(value = "Get all the runtime artifacts for a given API UUID and gateway label", notes = "This will provide access to runtime artifacts in database. ", response = Void.class, tags={ "Retrieving Runtime artifacts for gateway policies" })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "List of runtime Artifacts", response = Void.class),
        @ApiResponse(code = 200, message = "Unexpected error", response = ErrorDTO.class) })
    public Response gatewayPolicyArtifactsGet( @NotNull  @ApiParam(value = "This is used to specify the tenant domain, where the resource need to be   retrieved from. " ,required=true)@HeaderParam("xWSO2Tenant") String xWSO2Tenant,  @ApiParam(value = "**Search condition**.   Gateway policy mapping UUID ")  @QueryParam("policyMappingUuid") String policyMappingUuid,  @ApiParam(value = "**Search condition**.  type of gateway ")  @QueryParam("type") String type,  @ApiParam(value = "**Search condition**.  label associated with the policy mapping ")  @QueryParam("gatewayLabel") String gatewayLabel) throws APIManagementException{
        return delegate.gatewayPolicyArtifactsGet(xWSO2Tenant, policyMappingUuid, type, gatewayLabel, securityContext);
    }
}
