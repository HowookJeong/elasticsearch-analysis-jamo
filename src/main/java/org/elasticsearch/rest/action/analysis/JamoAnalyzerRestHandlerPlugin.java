package org.elasticsearch.rest.action.analysis;

import static java.util.Collections.singletonList;

import java.util.List;
import java.util.function.Supplier;
import org.elasticsearch.cluster.metadata.IndexNameExpressionResolver;
import org.elasticsearch.cluster.node.DiscoveryNodes;
import org.elasticsearch.common.settings.ClusterSettings;
import org.elasticsearch.common.settings.IndexScopedSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.settings.SettingsFilter;
import org.elasticsearch.plugins.ActionPlugin;
import org.elasticsearch.plugins.Plugin;
import org.elasticsearch.rest.RestController;
import org.elasticsearch.rest.RestHandler;

/**
 * Created by henry on 2018.8.28
 */
public class JamoAnalyzerRestHandlerPlugin extends Plugin implements ActionPlugin {

  @Override
  public List<RestHandler> getRestHandlers(final Settings settings,
    final RestController restController,
    final ClusterSettings clusterSettings,
    final IndexScopedSettings indexScopedSettings,
    final SettingsFilter settingsFilter,
    final IndexNameExpressionResolver indexNameExpressionResolver,
    final Supplier<DiscoveryNodes> nodesInCluster) {

    return singletonList(new JamoAnalyzerRestAction());
  }
}

