package br.edu.unifei.ecot13.basquete;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("basquetePU");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		Profissional gs = new Profissional();
		Profissional la = new Profissional();
		Profissional bc = new Profissional();
		Quadra q = new Quadra();
		q.setNome("Chase Center");
		gs.setQuadra(q);
		gs.setNome("Warriors");
		gs.setCidade("Sao Francisco");
		gs.setLiga("Western Pacific");
		la.setNome("Lakers");
		la.setCidade("Los Angeles");
		la.setLiga("Western Pacific");
		
		

		Armador pg0 = new Armador();
		Ala sf0 = new Ala();
		AlaArmador sg0 = new AlaArmador();
		AlaDeForca pf0 = new AlaDeForca();
		Pivo c0 = new Pivo();
		pg0.setNome("Stephen Curry");
		pg0.setAltura(1.88f);
		pg0.setNumero(30);
		pg0.setPeso(84f);
		pg0.setTime(gs);
		Tenis t = new Tenis();
		t.setMarca("Curry");
		t.setModelo("4s");
		t.setTamanho(13.5f);
		
		pg0.setTenis(t);
		sf0.setNome("Klay Thompson");
		sf0.setTime(gs);
		sf0.setNumero(11);
		sg0.setNome("Moses Moody");
		sg0.setNumero(4);
		sg0.setTime(gs);
		pf0.setNome("Draymond Green");
		pf0.setNumero(23);
		pf0.setTime(gs);
		c0.setNome("James Wiseman");
		c0.setNumero(33);
		c0.setTime(gs);
		gs.getJogadores().add(c0);
		gs.getJogadores().add(pg0);
		gs.getJogadores().add(sg0);
		gs.getJogadores().add(sf0);
		gs.getJogadores().add(pf0);
		
		
		Armador pg1 = new Armador();
		Ala sf1 = new Ala();
		AlaArmador sg1 = new AlaArmador();
		AlaDeForca pf1 = new AlaDeForca();
		AlaDeForca pf2 = new AlaDeForca();
		Pivo c1 = new Pivo();
		sf1.setNome("LeBron James");
		sf1.setNumero(6);
		sf1.setTime(la);
		pg1.setNome("Russel Westbrook");
		pg1.setNumero(0);
		pg1.setTime(la);
		pf1.setNome("Anthony Davis");
		pf1.setNumero(3);
		pf1.setTime(la);
		sg1.setNome("Kendrick Nunn");
		sg1.setNumero(12);
		sg1.setTime(la);
		c1.setNome("Thomas Bryant");
		c1.setNumero(13);
		c1.setTime(la);
		pf2.setNome("Carmelo Anthony");
		pf2.setNumero(7);
		pf2.setTime(la);
		la.getJogadores().add(c1);
		la.getJogadores().add(pg1);
		la.getJogadores().add(sg1);
		la.getJogadores().add(sf1);
		la.getJogadores().add(pf1);	
		la.getJogadores().add(pf2);
		

		Partida p = new Partida();
		p.setQuadra(q);
		
		p.setTime1(gs);
		p.setTime2(la);
		
		Arremesso a = new Arremesso();
		Bloqueio b = new Bloqueio();
		Passe pa = new Passe();
		Drible d = new Drible();
		Rebote r = new Rebote();
		a.setDistancia(5);
		b.setForca(15);
		pa.setDistancia(5);
		d.setVelocidade(10);
		r.setAltura(3);
		JogadaEnsaida je = new JogadaEnsaida();
		je.setNome("Jogada 1");
		
		em.persist(a);
		em.persist(b);
		em.persist(pa);
		em.persist(d);
		em.persist(r);
		
		em.persist(t);
		em.persist(pg0);
		em.persist(sf0);
		em.persist(sg0);
		em.persist(pf0);
		em.persist(c0);
		
		em.persist(pg1);
		em.persist(sf1);
		em.persist(sg1);
		em.persist(pf1);
		em.persist(pf2);
		em.persist(c1);
		
		em.persist(gs);
		em.persist(la);
		em.persist(q);
		em.persist(p);
		em.persist(je);
		
		em.getTransaction().commit();
		em.close();
		emf.close();

	}

}
