<template lang="pug">
    #locacao
        h1 Locação de veículos
        label Por favor escolha o arquivo de texto:
        upload
        formulario
        button.btn.btn-success.botaoVerificar(@click="enviarObjeto") Verificar
        br
        modal(v-show="getExibirModal" :resultado="getResultado")
</template>

<script>
import { mapGetters, mapState } from "vuex";
import Upload from "../shared/Upload";
import Modal from "../shared/Modal";
import Formulario from "./Formulario";

export default {
    name: "locacao",
    components: { Upload, Formulario, Modal },
    computed: {
        ...mapGetters([
            "objetoArquivo",
            "resultado"
        ]),
        getResultado(){
            if(this.resultado.categoriaCarro != "---"){
                this.exibirModal = true;
            }
            return this.resultado;
        },
        getExibirModal(){
            return this.exibirModal;
        }
    },
    data(){
        return {
            exibirModal: false
        }
    },
    methods: {
        enviarObjeto(){
            if(this.objetoArquivo.tipoCarro !== "---") {
                this.$store.dispatch('enviarObjetoArquivo', this.objetoArquivo);
            } else {
                console.log("Faça o upload do arquivo primeiro!");
            }
        }
    },
    created(){
        this.$bus.$on("fecharModal", () => this.exibirModal = false);
    }
}
</script>

<style scoped>
    #locacao {
        border: 2px solid #3B9C00;
        background-color: rgba(0, 0, 0, 0.3);
        border-radius: 5px;
        margin-top: 50px;
        text-align: center;
        color: #3B9C00;
        padding: 10px;
        background-color: #fff;
    }
    .botaoVerificar{
        float: right;
        margin-top: -20px;
        margin-right: 50px;
    }
</style>
