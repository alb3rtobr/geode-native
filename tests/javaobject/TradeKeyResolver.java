/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package javaobject;
import java.util.*;
import org.apache.geode.cache.PartitionAttributesFactory;
import org.apache.geode.cache.PartitionResolver;
import java.io.*;
import org.apache.geode.*;
import org.apache.geode.cache.Declarable;
import org.apache.geode.cache.EntryOperation;
import javaobject.TradeKey;

  public class TradeKeyResolver implements PartitionResolver, Serializable ,Declarable
  {
    public String getName() {
      return "TradeKeyResolver";
    }
	
    public Serializable getRoutingObject(EntryOperation opDetails) {	 
	 TradeKey key = (TradeKey)opDetails.getKey();
	 int id = key.getId() + 5;
	 System.out.println("TradeKeyResolver::getRoutingObject() java side routing object = " + id);
     return id ;
    }
    public void close() {}
    public Properties getProperties() { return new Properties(); }
	public void init(Properties props)
	{
	}
  }
