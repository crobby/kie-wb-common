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

package org.kie.workbench.common.stunner.core.client.canvas.command;

import org.kie.workbench.common.stunner.core.client.canvas.AbstractCanvasHandler;
import org.kie.workbench.common.stunner.core.client.command.CanvasViolation;
import org.kie.workbench.common.stunner.core.client.util.ShapeUtils;
import org.kie.workbench.common.stunner.core.command.CommandResult;
import org.kie.workbench.common.stunner.core.graph.Edge;
import org.kie.workbench.common.stunner.core.graph.content.view.ControlPoint;

public class DeleteCanvasControlPointCommand extends AbstractCanvasCommand {

    private final Edge candidate;
    private final ControlPoint[] controlPoints;

    public DeleteCanvasControlPointCommand(final Edge candidate, final ControlPoint... controlPoints) {
        this.candidate = candidate;
        this.controlPoints = controlPoints;
    }

    @Override
    public CommandResult<CanvasViolation> execute(AbstractCanvasHandler context) {
        ShapeUtils.hideControlPoints(candidate, context);
        ShapeUtils.removeControlPoints(candidate, context, controlPoints);
        ShapeUtils.showControlPoints(candidate, context);
        return buildResult();
    }

    @Override
    public CommandResult<CanvasViolation> undo(AbstractCanvasHandler context) {
        return newUndoCommand().execute(context);
    }

    protected AddCanvasControlPointCommand newUndoCommand() {
        return new AddCanvasControlPointCommand(candidate, controlPoints);
    }

    protected ControlPoint[] getControlPoints() {
        return controlPoints;
    }
}
