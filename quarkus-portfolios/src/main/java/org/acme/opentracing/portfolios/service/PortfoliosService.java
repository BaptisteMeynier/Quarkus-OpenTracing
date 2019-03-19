package org.acme.opentracing.portfolios.service;

import org.acme.opentracing.portfolios.model.Portfolio;

import java.util.HashSet;
import java.util.Set;

public class PortfoliosService {

    private static Set<Portfolio> portfolioSet = new HashSet<>(10);
    static {
        portfolioSet.add(new Portfolio("PTF000",9800));
        portfolioSet.add(new Portfolio("PTF001",5000));
        portfolioSet.add(new Portfolio("PTF002",100));
        portfolioSet.add(new Portfolio("PTF003",300));
        portfolioSet.add(new Portfolio("PTF004",15000));
        portfolioSet.add(new Portfolio("PTF005",2000));
        portfolioSet.add(new Portfolio("PTF006",9000));
        portfolioSet.add(new Portfolio("PTF007",1600));
        portfolioSet.add(new Portfolio("PTF008",2500));
        portfolioSet.add(new Portfolio("PTF009",10000));
    }

    public Set<Portfolio> getPortfolios(){
        return portfolioSet;
    }
}
