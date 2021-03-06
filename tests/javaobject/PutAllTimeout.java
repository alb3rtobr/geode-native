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

import org.apache.logging.log4j.*;

import org.apache.geode.cache.CacheListener;
import org.apache.geode.cache.EntryEvent;
import org.apache.geode.cache.RegionEvent;
import org.apache.geode.cache.CacheFactory;
import org.apache.geode.cache.Declarable;
import org.apache.geode.internal.cache.tier.sockets.CacheClientProxy;


public class PutAllTimeout implements Declarable, CacheListener {

  final Logger log = LogManager.getLogger(getClass());

  public PutAllTimeout() 
  {
  }
  
  public void init(Properties props) {
    CacheClientProxy.isSlowStartForTesting = true;
  }

  public void afterCreate(EntryEvent event) {
    try
    {
     if (event.getKey().toString().indexOf("timeout") >= 0) {
        
        int sleepVal = Integer.parseInt( event.getNewValue().toString() );
        log.info("Put all timeout value " + event.getNewValue().toString());
        log.info("Put all timeout " + sleepVal);
        Thread.sleep(sleepVal);
        log.info("Put all sleep done");
      }              
    }catch(InterruptedException e)
    {
      
    }
    catch(Exception e)
    {
      System.out.println("Exception: After create " + e.getMessage());
    }
   }
   public void afterUpdate(EntryEvent event) 
   {
     try
     {
       if (event.getKey().toString().indexOf("timeout") >= 0) {
         int sleepVal = Integer.parseInt( event.getNewValue().toString() );
         log.info("Put all timeout " + sleepVal);
         Thread.sleep(sleepVal);
         log.info("Put all sleep done");
       }              
     }catch(InterruptedException e)
     {
       
     }
     catch(Exception e)
     {
       log.info("Exception: After update " + e.getMessage());
     }
   }
  
    public void afterInvalidate(EntryEvent event)
    {
    }

    public void afterDestroy(EntryEvent event)
    {
    }

    public void afterRegionInvalidate(RegionEvent event)
    {
    }

    public void afterRegionDestroy(RegionEvent event)
    {
    }

    public void afterRegionClear(RegionEvent event)
    {
    }

    public void afterRegionCreate(RegionEvent event)
    {
    }
    
    public void afterRegionLive(RegionEvent event)
    {
    }

    public void close()
    {
    }
}
