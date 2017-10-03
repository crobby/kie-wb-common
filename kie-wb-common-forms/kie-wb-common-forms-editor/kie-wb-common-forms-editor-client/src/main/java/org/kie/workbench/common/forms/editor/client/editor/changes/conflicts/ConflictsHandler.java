/*
 * Copyright 2017 Red Hat, Inc. and/or its affiliates.
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

package org.kie.workbench.common.forms.editor.client.editor.changes.conflicts;

import java.util.function.Consumer;

import org.kie.workbench.common.forms.editor.client.editor.changes.conflicts.element.ConflictElement;
import org.kie.workbench.common.forms.editor.model.FormModelerContent;
import org.kie.workbench.common.forms.model.FormDefinition;

/**
 * Component able to handle possible conflicts on the {@link FormModelerContent} for the {@link FormDefinition} which is
 * being edited.
 */
public interface ConflictsHandler {

    /**
     * Checks if the {@link FormModelerContent} has any conflict
     * @param content The actual {@link FormModelerContent} for the {@link FormDefinition} that is being edited.
     * @param conflictElementConsumer A Consumer that consumes {@link ConflictElement} generated by this handler
     * @return True if there are conflicts false if not.
     */
    boolean checkConflicts(FormModelerContent content,
                           Consumer<ConflictElement> conflictElementConsumer);

    /**
     * Method that is going to be called when conflicts are accepted. It should fix the conflicts and leave the edited
     * {@link FormDefinition} in a state which it could be deployed without causing any problem.
     */
    void onAccept();
}