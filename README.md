meeting
=======

* Troubles
** Probelm 1. JBossWSが起動できない
# ���� Windows7 64bit

```
18:51:24,287 ERROR [org.jboss.as.controller.management-operation] (ServerService Thread Pool -- 46) JBAS014612: ���� ("add") �̎��s - �A�h���X: ([("subsystem" => "webservices")]) : java.lang.IllegalArgumentException: JBWS022117: Invalid address provided: <<�}�V���̃z�X�g��>>
	at org.jboss.ws.common.management.AbstractServerConfig.toIPv6URLFormat(AbstractServerConfig.java:129)
	at org.jboss.ws.common.management.AbstractServerConfig.setWebServiceHost(AbstractServerConfig.java:115)
	at org.jboss.as.webservices.dmr.WSSubsystemAdd.createServerConfig(WSSubsystemAdd.java:101)
	at org.jboss.as.webservices.dmr.WSSubsystemAdd.performBoottime(WSSubsystemAdd.java:88)
	at org.jboss.as.controller.AbstractBoottimeAddStepHandler.performRuntime(AbstractBoottimeAddStepHandler.java:57) [jboss-as-controller-7.3.0.Final-redhat-14.jar:7.3.0.Final-redhat-14]
	at org.jboss.as.controller.AbstractAddStepHandler$1.execute(AbstractAddStepHandler.java:76) [jboss-as-controller-7.3.0.Final-redhat-14.jar:7.3.0.Final-redhat-14]
	at org.jboss.as.controller.AbstractOperationContext.executeStep(AbstractOperationContext.java:607) [jboss-as-controller-7.3.0.Final-redhat-14.jar:7.3.0.Final-redhat-14]
	at org.jboss.as.controller.AbstractOperationContext.doCompleteStep(AbstractOperationContext.java:485) [jboss-as-controller-7.3.0.Final-redhat-14.jar:7.3.0.Final-redhat-14]
	at org.jboss.as.controller.AbstractOperationContext.completeStepInternal(AbstractOperationContext.java:282) [jboss-as-controller-7.3.0.Final-redhat-14.jar:7.3.0.Final-redhat-14]
	at org.jboss.as.controller.AbstractOperationContext.executeOperation(AbstractOperationContext.java:277) [jboss-as-controller-7.3.0.Final-redhat-14.jar:7.3.0.Final-redhat-14]
	at org.jboss.as.controller.ParallelBootOperationStepHandler$ParallelBootTask.run(ParallelBootOperationStepHandler.java:343) [jboss-as-controller-7.3.0.Final-redhat-14.jar:7.3.0.Final-redhat-14]
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1110) [rt.jar:1.7.0_03]
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:603) [rt.jar:1.7.0_03]
	at java.lang.Thread.run(Thread.java:722) [rt.jar:1.7.0_03]
	at org.jboss.threads.JBossThread.run(JBossThread.java:122) [jboss-threads-2.1.1.Final-redhat-1.jar:2.1.1.Final-redhat-1]
```

** A. JBossWSをOFFにして回避

standalone.xml

```

        <!-- extension module="org.jboss.as.webservices"/-->

(����)

<!--
        <subsystem xmlns="urn:jboss:domain:webservices:1.2">
            <modify-wsdl-address>true</modify-wsdl-address>
            <wsdl-host>${jboss.bind.address:127.0.0.1}</wsdl-host>
            <endpoint-config name="Standard-Endpoint-Config"/>
            <endpoint-config name="Recording-Endpoint-Config">
                <pre-handler-chain name="recording-handlers" protocol-bindings="##SOAP11_HTTP ##SOAP11_HTTP_MTOM ##SOAP12_HTTP ##SOAP12_HTTP_MTOM">
                    <handler name="RecordingHandler" class="org.jboss.ws.common.invocation.RecordingServerHandler"/>
                </pre-handler-chain>
            </endpoint-config>
            <client-config name="Standard-Client-Config"/>
        </subsystem>
-->

```