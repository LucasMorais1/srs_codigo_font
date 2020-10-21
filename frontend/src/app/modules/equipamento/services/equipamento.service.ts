import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { environment } from 'src/environments/environment';
import { CadastroEquipamentoModel } from '../models/cadastro-equipamento.model';
import { EditarEquipamentoModel } from '../models/editar-equipamento.model';
import { InfoEquipamentoModel } from '../models/info-equipamento.model';
import { ListarEquipamentoModel } from '../models/listar-equipamento.model';

@Injectable({
  providedIn: 'root'
})
export class EquipamentoService {

  

  constructor(
    private http: HttpClient
  ) { }

  recuperarEquipamento(id: number): Observable<InfoEquipamentoModel> {

    return this.http.get<InfoEquipamentoModel>(`${environment.apiUrl}/equipamentos/${id}`);
   }

  deletarEquipamento(id: number): Observable<InfoEquipamentoModel> {
    return this.http.delete<InfoEquipamentoModel>(`${environment.apiUrl}/equipamentos/${id}`);
   }

  listarEquipamentos():Observable<ListarEquipamentoModel[]>{
    return of<ListarEquipamentoModel[]>([{
      id: 1,
      nome: "Geladeira",
      preco: 1290.90,
      idTipoEquipamento: 2
    },
    {
      id: 2,
      nome: "NoteBook",
      preco: 2590.90,
      idTipoEquipamento: 3
    }]);
    return this.http.get<ListarEquipamentoModel[]>(`${environment.apiUrl}/equipamentos`);
  }

  cadastrarEquipamento(cadastroEquipamento: CadastroEquipamentoModel): Observable<InfoEquipamentoModel> {
    return 
    return this.http.post<InfoEquipamentoModel>(`${environment.apiUrl}/equipamentos`,cadastroEquipamento);
  }

  editarEquipamento(cadastroEquipamento: EditarEquipamentoModel): Observable<InfoEquipamentoModel> {
    return this.http.put<InfoEquipamentoModel>(`${environment.apiUrl}/equipamentos/`,cadastroEquipamento);
  }

}
