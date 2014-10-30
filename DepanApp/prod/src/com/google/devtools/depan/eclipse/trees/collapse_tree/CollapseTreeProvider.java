/*
 * Copyright 2014 Pnambic Computing.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.google.devtools.depan.eclipse.trees.collapse_tree;

import com.google.devtools.depan.view.CollapseData;

/**
 * @author ycoppel@google.com (Yohann Coppel)
 *
 * @param <E> the type of objects contained in the tree, associated to each
 *        Node<Element>.
 */
public interface CollapseTreeProvider<E> {
  public E getObject(CollapseData node);
}