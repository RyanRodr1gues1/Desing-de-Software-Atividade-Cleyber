/*
 * NEXUSLOG - COMENTÁRIOS DIDÁTICOS
 * Arquivo: PatternsDemo.java
 *
 * Finalidade:
 * CLASSE DE DEMONSTRAÇÃO: ponto de entrada usado para tornar o comportamento do projeto observável em sala.
 *
 * Leitura recomendada em aula:
 * 1) identifique a responsabilidade desta classe;
 * 2) identifique de quais abstrações ela depende;
 * 3) observe o que mudaria se surgisse uma nova regra/integração;
 * 4) relacione a decisão a coesão, acoplamento, SOLID e/ou padrão de projeto.
 */
package br.edu.nexuslog;

import br.edu.nexuslog.domain.Shipment;
import br.edu.nexuslog.integration.CorreiosAdapter;
import br.edu.nexuslog.integration.external.CorreiosLegacyClient;
import br.edu.nexuslog.patterns.strategy.*;
import br.edu.nexuslog.patterns.observer.*;
import br.edu.nexuslog.patterns.abstractfactory.*;
import br.edu.nexuslog.patterns.facade.NexusLogFacade;
import br.edu.nexuslog.patterns.factorymethod.*;

// Classe concreta: implementa uma responsabilidade específica dentro do desenho.

public class PatternsDemo {
    public static void main(String[] args) {
        Shipment shipment = new Shipment("PED-100", "Ana", 12.0);

        // Strategy
        FreightStrategy freight = new ExpressFreight();

        // Adapter
        CorreiosAdapter carrier = new CorreiosAdapter(new CorreiosLegacyClient());

        // Observer
        DeliveryEventPublisher publisher = new DeliveryEventPublisher();
        publisher.subscribe(new EmailObserver());
        publisher.subscribe(new OperationsObserver());

        // Abstract Factory
        LogisticsServiceFactory serviceFactory = new CorreiosServiceFactory();

        // Facade orquestrando Strategy + Adapter + Observer + Abstract Factory
        NexusLogFacade facade = new NexusLogFacade(carrier, publisher);
        facade.process(shipment, freight, serviceFactory);

        // Factory Method
        VehicleCreator creator = new VanCreator();
        System.out.println(creator.planRoute());
    }
}
