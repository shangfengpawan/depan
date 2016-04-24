/*
 * Copyright 2016 The Depan Project Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.devtools.depan.model.builder.api;

import com.google.devtools.depan.model.GraphEdge;
import com.google.devtools.depan.model.GraphModel;
import com.google.devtools.depan.model.GraphNode;
import com.google.devtools.depan.model.builder.simple.GraphModelBuilder;

import java.util.Collection;

/**
 * Mostly stolen from the earlier version of GraphModel.
 * 
 * @author Lee Carver
 *
 */
public class GraphBuilders {

  private GraphBuilders() {
    // Prevent instanciation.
  }

  public static GraphBuilder createGraphModelBuilder() {
    return new GraphModelBuilder();
  }

  /**
   * Build a graph given a collection of edges. Nodes are those involved in at
   * least one relation.
   *
   * @param sourceEdges list of edges in the graph
   * @return a GraphModel made from the given collection of Edge, and Node
   *         involved in those relations.
   */
  public static GraphModel buildFromEdges(
      GraphModel master, Collection<GraphEdge> sourceEdges) {

    GraphBuilder builder = createGraphModelBuilder();

    for (GraphEdge e : master.getEdges()) {
      GraphNode head = builder.mapNode(e.getHead());
      GraphNode tail = builder.mapNode(e.getTail());
      GraphEdge edge = new GraphEdge(head, tail, e.getRelation());
      builder.addEdge(edge);
    }

    return builder.createGraphModel();
  }
}
