package com.distelli.europa.ajax;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

import com.distelli.europa.clients.*;
import com.distelli.europa.db.*;
import com.distelli.europa.models.*;
import com.distelli.gcr.*;
import com.distelli.gcr.auth.*;
import com.distelli.gcr.models.*;
import com.distelli.persistence.*;
import com.distelli.webserver.*;
import com.google.inject.Singleton;
import org.eclipse.jetty.http.HttpMethod;
import lombok.extern.log4j.Log4j;
import javax.inject.Inject;
import com.distelli.europa.EuropaRequestContext;
import com.distelli.europa.util.PermissionCheck;

@Log4j
@Singleton
public class RemovePipelineComponent extends AjaxHelper<EuropaRequestContext>
{
    @Inject
    private PipelineDb _db;
    @Inject
    protected PermissionCheck _permissionCheck;

    public RemovePipelineComponent()
    {
        this.supportedHttpMethods.add(HTTPMethod.POST);
    }

    public Object get(AjaxRequest ajaxRequest, EuropaRequestContext requestContext)
    {
        String pipelineId = ajaxRequest.getParam("pipelineId", true);
        String pipelineComponentId = ajaxRequest.getParam("pipelineComponentId", true);
        _permissionCheck.check(ajaxRequest.getOperation(), requestContext, pipelineId);

        _db.removePipelineComponent(pipelineId, pipelineComponentId);

        return _db.getPipeline(pipelineId);
    }
}
