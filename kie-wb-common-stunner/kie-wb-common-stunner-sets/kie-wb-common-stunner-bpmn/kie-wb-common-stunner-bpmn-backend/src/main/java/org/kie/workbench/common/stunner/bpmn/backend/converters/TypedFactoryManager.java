/*
 * Copyright 2018 Red Hat, Inc. and/or its affiliates.
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

package org.kie.workbench.common.stunner.bpmn.backend.converters;

import org.kie.workbench.common.stunner.core.api.FactoryManager;
import org.kie.workbench.common.stunner.core.diagram.Diagram;
import org.kie.workbench.common.stunner.core.diagram.Metadata;
import org.kie.workbench.common.stunner.core.graph.Edge;
import org.kie.workbench.common.stunner.core.graph.Graph;
import org.kie.workbench.common.stunner.core.graph.Node;
import org.kie.workbench.common.stunner.core.graph.content.definition.DefinitionSet;
import org.kie.workbench.common.stunner.core.graph.content.view.View;

/**
 * A type-safe wrapper to a FactoryManager.
 * <p>
 * Returns nodes, edges and graphs of the requested type.
 * It is a
 */
public class TypedFactoryManager {

    private final FactoryManager factoryManager;

    public TypedFactoryManager(FactoryManager factoryManager) {
        this.factoryManager = factoryManager;
    }

    public FactoryManager untyped() {
        return factoryManager;
    }

    public <R, U extends R> Node<View<R>, Edge> newNode(String s, Class<U> aClass) {
        return (Node<View<R>, Edge>) factoryManager.newElement(s, aClass);
    }

    public <R, U extends R> Edge<View<R>, Node> newEdge(String s, Class<U> aClass) {
        return (Edge<View<R>, Node>) factoryManager.newElement(s, aClass);
    }

    public Diagram<Graph<DefinitionSet, Node>, Metadata> newDiagram(String s, Class<?> aClass, Metadata metadata) {
        return factoryManager.newDiagram(s, aClass, metadata);
    }
}
