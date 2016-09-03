package br.com.brunoluz.breeweer.service.eventos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import br.com.brunoluz.breeweer.storage.FotoStorage;

@Component
public class CervejaSalvaListener {

	@Autowired
	private FotoStorage fotoStorage;
	
	@EventListener(condition = "#evento.temFoto()")
	public void cervejaSalva(CervejaSalvaEvento evento) {
		fotoStorage.salvar(evento.getCerveja().getFoto());
	}
	
}
