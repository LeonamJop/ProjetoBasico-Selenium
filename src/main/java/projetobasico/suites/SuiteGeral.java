package projetobasico.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import projetobasico.tests.ContaTest;
import projetobasico.tests.MovimentacaoTest;
import projetobasico.tests.RemoverMovimentacaoContaTest;
import projetobasico.tests.ResumoTest;
import projetobasico.tests.SaldoTest;

@RunWith(Suite.class)

@SuiteClasses({
	ContaTest.class,
	MovimentacaoTest.class,
	RemoverMovimentacaoContaTest.class,
	SaldoTest.class,
	ResumoTest.class
})

public class SuiteGeral {

}
