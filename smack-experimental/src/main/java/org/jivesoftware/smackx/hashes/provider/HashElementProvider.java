/**
 *
 * Copyright © 2017 Paul Schaub
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
package org.jivesoftware.smackx.hashes.provider;

import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smackx.hashes.HashManager;
import org.jivesoftware.smackx.hashes.element.HashElement;
import org.xmlpull.v1.XmlPullParser;

/**
 * Provider for HashElements.
 */
public class HashElementProvider extends ExtensionElementProvider<HashElement> {

    @Override
    public HashElement parse(XmlPullParser parser, int initialDepth) throws Exception {
        String algo = parser.getAttributeValue(null, HashElement.ATTR_ALGO);
        String hashB64 = parser.nextText();
        return new HashElement(HashManager.ALGORITHM.valueOfName(algo), hashB64);
    }
}
