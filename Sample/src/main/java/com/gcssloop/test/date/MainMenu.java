/*
 * Copyright (c) 2016 GcsSloop
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * GitHub :  https://github.com/GcsSloop
 * Weibo  :  http://weibo,com/GcsSloop
 * Blog     :  http://www.gcssloop.com
 *
 * Last modify $2016-09-15 05:43:53
 */

package com.gcssloop.test.date;

import com.gcssloop.test.viewsupport.TestCustomViewActivity;
import com.gcssloop.test.viewsupport.TestRorate3dAnimationActivity;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    public static List<MenuEntity> menu = new ArrayList<MenuEntity>();

    static{
        menu.add(new MenuEntity("CustomView测试", TestCustomViewActivity.class)) ;
        menu.add(new MenuEntity("Rotate3dAnimation测试", TestRorate3dAnimationActivity.class)) ;
    }

    public static class MenuEntity{
        public String info;
        public Class<?> goClass;
        public MenuEntity(String info,Class<?> goClass) {
            this.info=info;
            this.goClass=goClass;
        }
    }
}
