fuga da prisão {
	usuario (move e investiga)
	objeto que faz som (alerta, chama guarda)
	objeto com fala que muda aparencia
	obejto que guarda a chave
	porta
	guarda (chão muda)
}

barulho 1 -> Guarda: "Ei! pare de fazer barulho, esse é seu último aviso"
barulho 2 -> gameover

1.1- Escrivaninha: "aqui no bilhete diz que eles deixaram uma chave em algum lugar"
1.2- Escrivaninha: if "pedaço de espelho" and "roupa extra" == true -> pode fazer uma faca 

2.1- Vaso: "Pelo menos me deixaram papel" pegar ou deixar

3.1- Espelho: "O espelho parece ter uma parte quebrada" pegar ou deixar
3.2- Espelho: if papel == true -> pegar sem barulho
3.3- Espelho: if papel == false -> faz barulho

4.1- Roupas: "Deixaram roupas a mais" pegar ou deixar

5.1- Cadeira: if faca == false "isso parece ter um fundo falso, mas eu não consigo abrir"
5.2- Cadeira: if faca == true "usar a faca para abrir? sim ou não 
5.2.1- Cadeira: if "sim" -> "achou a chave"

6.1- Cama: faz barulho