import Formulario from "../../services/formulario";

export const state = {
  objetoArquivo: {
    tipoCarro:  '---',
    quantidadePassageiros:  "---",
    intervaloData:  [ 
        "---", 
        "---"
    ]
  },
  carroEscolhido: '',
  resultado: {
    categoriaCarro: "---",
    nomeLoja: " ---",
    valorTotal: "---"
  } 
};

export const getters = {
  objetoArquivo: state => state.objetoArquivo,
  carroEscolhido: state => state.carroEscolhido,
  resultado: state => state.resultado
};

export const actions = {
  
  enviarObjetoArquivo: ({ commit }, objetoArquivo) => {

    Formulario.enviarObjetoArquivo(objetoArquivo)
      .then( ({ data }) => {
        commit('resposta_success', data);
      })
      .catch(() => {
        commit('resposta_error');
      })
  },

  armazenarTextoArquivo: ({ commit }, textoArquivo) => {
    commit('armazenar_texto_arquivo', textoArquivo);
  }
}

export const mutations = {
  armazenar_texto_arquivo: (state, textoArquivo) => (state.objetoArquivo = textoArquivo),

  resposta_success: (state, carroEscolhido) => (state.resultado = carroEscolhido),

  resposta_error: (state) => 
  (
    state.resultado = 
    {
      categoriaCarro: "---",
      nomeLoja: " ---",
      valorTotal: "---"
    } 
  )
};

export default {
  state,

  getters,

  actions,

  mutations
};
