package com.example.test_project;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TextFormatterTests {

	String format(String texto) {
		return new Formatter(texto).format();
	}

	@Test()
	void assinalaOcorrencia1() {
		assertEquals("a*trecho*", format("a*trecho*"));
	}

	@Test
	void assinalaOcorrencia2() {
		assertEquals("<b>*trecho<b/>", format("**trecho*"));
	}

	@Test
	void assinalaOcorrencia3() {
		assertEquals("<b><c>Deus é <i>bom todo<i/> o tempo<c/><b/>", format("*~Deus é _bom todo_ o tempo~*"));
	}

	@Test
	void assinalaOcorrencia4() {
		assertEquals("<b>trecho *trecho<b/> trecho*", format("*trecho *trecho* trecho*"));
	}

	@Test
	void assinalaOcorrencia5() {
		assertEquals("<i>hoje é um <c>grande<c/> dia<i/>", format("_hoje é um ~grande~ dia_"));
	}

	@Test
	void assinalaOcorrencia6() {
		assertEquals(" <i>hoje é um <c>grande<c/> dia<i/> ", format(" _hoje é um ~grande~ dia_ "));
	}

	@Test
	void assinalaOcorrencia7() {
		assertEquals("<i>hoje é um <c>grande<c/> dia para <b>agradecermos<b/> a <b>Deus<b/> pelo vida que temos<i/>",
				format("_hoje é um ~grande~ dia para *agradecermos* a *Deus* pelo vida que temos_"));
	}

	@Test
	void assinalaOcorrencia8() {
		assertEquals("xyz abc", format("xyz abc"));
	}

	@Test
	void assinalaOcorrencia9() {
		assertEquals("<i>*trecho<i/>*", format("_*trecho_*"));
	}

	@Test
	void assinalaOcorrencia10() {
		assertEquals("*trecho *", format("*trecho *"));
	}

	@Test
	void assinalaOcorrencia11() {
		assertEquals("*trecho*a", format("*trecho*a"));
	}

	@Test
	void assinalaOcorrencia12() {
		assertEquals("<b>trecho<b/>*", format("*trecho**"));
	}

	@Test
	void assinalaOcorrencia13() {
		assertEquals("~<b>trecho<b/>", format("~*trecho*"));
	}

	@Test
	void assinalaOcorrencia14() {
		assertEquals("~<b>trecho<b/>", format("~*trecho*"));
	}

	@Test
	void assinalaOcorrencia15() {
		assertEquals("<i>trecho *trecho<i/> trecho*", format("_trecho *trecho_ trecho*"));
	}

	@Test
	void assinalaOcorrencia16() {
		assertEquals("<i>trecho _trecho<i/> trecho_", format("_trecho _trecho_ trecho_"));
	}

	@Test
	void assinalaOcorrencia17() {
		assertEquals("<c>trecho ~trecho<c/> trecho~", format("~trecho ~trecho~ trecho~"));
	}

	@Test
	void assinalaOcorrencia18() {
		assertEquals("trecho trecho <b>trecho~<b/>*", format("trecho trecho *trecho~**"));
	}

	@Test
	void assinalaOcorrencia19() {
		assertEquals(
				"<b>p p p *p *p p p<b/> p* <i>p p, p  <b>p p p<b/> p p<i/>",
				format("*p p p *p *p p p* p* _p p, p  *p p p* p p_"));
	}
	
	@Test
	void assinalaOcorrencia20() {
		assertEquals("&~trecho <c>trecho<c/> trecho~", format("&~trecho ~trecho~ trecho~"));
	}
	
	@Test
	void assinalaOcorrencia21() {
		assertEquals("*<c>trecho ~trecho<c/> trecho~", format("*~trecho ~trecho~ trecho~"));
	}
	
	@Test
	void assinalaOcorrencia22() {
		assertEquals("<b>trecho *<c><i>trecho<i/><c/><b/> trecho*", format("*trecho *~_trecho_~* trecho*"));
	}
	
	@Test
	void assinalaOcorrencia23() {
		assertEquals("<i><b>~trecho<b/>~<i/>", format("_*~trecho*~_"));
	}
	
	@Test
	void assinalaOcorrencia24() {
		assertEquals("<c>trecho<c/><b>trecho<b/>", format("~trecho~*trecho*"));
	}
	
	@Test
	void assinalaOcorrencia25() {
		assertEquals("~trecho~a*trecho*", format("~trecho~a*trecho*"));
	}
	
	
	
	
}
