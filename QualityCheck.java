/*
 * NEXUSLOG - COMENTÁRIOS DIDÁTICOS
 * Arquivo: QualityCheck.java
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
import br.edu.nexuslog.patterns.strategy.*;

// Classe concreta: implementa uma responsabilidade específica dentro do desenho.

public class QualityCheck {
    public static void main(String[] args) {
        Shipment s = new Shipment("T1", "Teste", 10.0);
        double economic = new EconomicFreight().calculate(s);
        if (Math.abs(economic - 25.0) > 0.0001) {
            throw new AssertionError("Cálculo econômico incorreto");
        }
        System.out.println("QualityCheck OK");
    }
}
