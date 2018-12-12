package com.sample;
import org.apache.log4j.Logger;
import org.drools.KnowledgeBase;
import org.drools.builder.DecisionTableConfiguration;
import org.drools.builder.DecisionTableInputType;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatefulKnowledgeSession;
import org.drools.runtime.StatelessKnowledgeSession;

public class CalculationXls {
    public static void main(String[] args) {
        System.out.println("开始");
        DecisionTableConfiguration dtc=KnowledgeBuilderFactory.newDecisionTableConfiguration();
        dtc.setInputType(DecisionTableInputType.XLS);
        KnowledgeBuilder builder=KnowledgeBuilderFactory.newKnowledgeBuilder();
        builder.add(ResourceFactory.newClassPathResource("com/sample/calculation.xls", CalculationXls.class),ResourceType.DTABLE,dtc);
        KnowledgeBase base=builder.newKnowledgeBase();
        base.addKnowledgePackages(base.getKnowledgePackages());
        StatelessKnowledgeSession sk = base.newStatelessKnowledgeSession();
        Calculation cal=new Calculation(10000,9500.0);
//        sk.setGlobal("hehe",cal);
        sk.execute(cal);
//        StatefulKnowledgeSession session=base.newStatefulKnowledgeSession();
//        Calculation cal=new Calculation(10000,6500.0);
//        System.out.println(cal);
//        session.insert(cal);
//        session.fireAllRules();
//        session.dispose();
        System.out.println("结束");
    }
}
