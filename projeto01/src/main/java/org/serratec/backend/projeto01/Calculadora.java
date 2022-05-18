package org.serratec.backend.projeto01;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Calculadora {
	
	public int valor;
	
	
	@RequestMapping("/calculadora")
	public List Calculadora(@RequestParam int x, @RequestParam int y) {
		List<Integer> resultados = new ArrayList<Integer>();
		int res1, res2, res3, res4;
		res1 = x + y;
		resultados.add(res1);
		res2 = x - y;
		resultados.add(res2);
		res3 = x * y;
		resultados.add(res3);
		res4 = x / y;
		resultados.add(res4);
		return resultados; 
	}
}
