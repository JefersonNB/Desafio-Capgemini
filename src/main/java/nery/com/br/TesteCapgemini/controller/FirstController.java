package nery.com.br.TesteCapgemini.controller;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nery.com.br.TesteCapgemini.model.Item1;

@RestController
@RequestMapping("/teste")
public class FirstController {

	@PostMapping("/1")
	public ResponseEntity<String> teste1(@RequestBody Item1 numero){
		String resposta="";
		if (numero != null && numero.getNumero() != null) {
			int qtd = (Integer) numero.getNumero().length;
			if(qtd > 2) {
				int res = qtd % 2;
				if(res > 0) {
					qtd = qtd / 2;
					resposta = "O meio do Array é no indice " + qtd + " com valor " + numero.numero[qtd];
					return ResponseEntity.ok(resposta);
				}
			}
		}
		return ResponseEntity.badRequest().body("Array vazio ou com numero par");
	}
	
	@PostMapping("/2")
	public ResponseEntity<String> teste2(@RequestBody Item1 numero){
		ArrayList<String> conjunto = new ArrayList<String>();
		String resposta="";
		if (numero != null && numero.getNumero() != null) {
			for(int num: numero.getNumero()) {
				for (int num2: numero.getNumero()) {
					if(num < num2) {
						if(num2 - num == numero.getX()) {
							conjunto.add(""+num2+":"+num);
						}
					}
				}
			}
		}
		resposta = "Existem " + conjunto.size() + " pares de inteiros no vetor com uma diferença de " + numero.getX() + ": " + conjunto.toString();
		return ResponseEntity.ok(resposta);
	}
	
	@PostMapping("/3")
	public ResponseEntity<String> teste3(@RequestBody Item1 item){
		
		String texto = item.getTexto().replace(" ", "");
		int qtdchar = texto.length();		
		qtdchar = (int) Math.sqrt(qtdchar);
		qtdchar++;		
		String vetor[][] = new String [qtdchar][qtdchar];
		int count = 0;
		
		/*populando o vetor com os caracteres da string*/
		for (int i=0; i<vetor.length; i++) {
		    System.out.printf("%da. linha: ", (i+1));
		    for (int j=0; j<vetor[i].length; j++) {
		    	if(count == texto.length()) {
		    		vetor[i][j] = texto.substring(count, count);
		    	}else if(count > texto.length()){
		    		vetor[i][j]="";
		    	}else {
		    		vetor[i][j] = texto.substring(count, count+1);
		    		
		    	}
		    	count++;
		    	System.out.printf(vetor[i][j]);
//		    	System.out.print(count);
		    }
		    System.out.printf("\n");
		 }
		
		////////////////////
		/*criando nova string criptografada*/
		String text[][] = new String[1][qtdchar];
		for (int i=0; i<vetor.length; i++) {
		    for (int j=0; j<vetor[i].length; j++) {		    	
		    	text[0][j] += vetor[i][j];
		    }		    
		}
		String resp = Arrays.deepToString(text).replace("null", "").replace("[", "").replace("]", "").replace(",", "");
		System.out.println(resp);
		
		
		return ResponseEntity.ok(resp);
	}
}
