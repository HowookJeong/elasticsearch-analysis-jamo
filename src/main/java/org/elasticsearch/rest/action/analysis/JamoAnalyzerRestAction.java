package org.elasticsearch.rest.action.analysis;

import static java.util.Arrays.asList;
import static java.util.Collections.unmodifiableList;
import static org.elasticsearch.rest.RestRequest.Method.GET;
import static org.elasticsearch.rest.RestRequest.Method.POST;

import java.io.IOException;
import java.util.List;
import org.elasticsearch.client.node.NodeClient;
import org.elasticsearch.rest.BaseRestHandler;
import org.elasticsearch.rest.BytesRestResponse;
import org.elasticsearch.rest.RestRequest;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.rest.action.analysis.arirang.HanguelJamoMorphTokenizer;
import org.elasticsearch.rest.action.analysis.arirang.HanguelJamoType;

/**
 * Created by henry on 2018.8.28
 */
public class JamoAnalyzerRestAction extends BaseRestHandler {

  @Override
  public String getName() {
    return "analysis_jamo_action";
  }

  @Override
  public List<Route> routes() {
    return unmodifiableList(asList(
        new Route(GET, "/_jamo"),
        new Route(POST, "/_jamo")));
  }

  @Override
  protected RestChannelConsumer prepareRequest(RestRequest restRequest, NodeClient client)
      throws IOException {
      return doArirangJamoTokenizer(restRequest, client);
  }

  protected RestChannelConsumer doArirangJamoTokenizer(RestRequest restRequest, NodeClient client)
      throws IOException {
    String jamoToken = "";

    try {
      jamoToken = HanguelJamoMorphTokenizer.getInstance().tokenizer(
          restRequest.param("text", ""),
          restRequest.param("token", HanguelJamoType.JAMO.getName())
      );
    } catch (Exception e) {
      return channel -> channel.sendResponse(
          new BytesRestResponse(RestStatus.NOT_ACCEPTABLE, "Failed which jamo tokenizer!!"));
    } finally {
    }

    final String finalToken = jamoToken;

    return channel -> channel.sendResponse(new BytesRestResponse(RestStatus.OK, finalToken));
  }
}
