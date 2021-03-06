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

package org.kie.workbench.common.stunner.bpmn.backend.converters.fromstunner.properties;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import bpsim.ElementParameters;
import org.eclipse.bpmn2.FlowElementsContainer;
import org.eclipse.bpmn2.ItemDefinition;
import org.eclipse.bpmn2.RootElement;

class Processes {
    static void addChildElement(
            PropertyWriter p,
            Map<String, BasePropertyWriter> childElements,
            FlowElementsContainer process,
            Collection<ElementParameters> simulationParameters,
            List<ItemDefinition> itemDefinitions,
            List<RootElement> rootElements) {
        childElements.put(p.getElement().getId(), p);
        // compatibility fix: boundary events should always occur at the bottom
        // otherwise they will be drawn at an incorrect position on load
        if (p instanceof BoundaryEventPropertyWriter) {
            process.getFlowElements().add(p.getFlowElement());
        } else {
            process.getFlowElements().add(0, p.getFlowElement());
        }

        ElementParameters sp = p.getSimulationParameters();
        if (sp!= null) {
            simulationParameters.add(sp);
        }
        itemDefinitions.addAll(p.getItemDefinitions());
        rootElements.addAll(p.rootElements);
    }
}
