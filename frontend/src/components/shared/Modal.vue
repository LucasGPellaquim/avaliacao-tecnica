<template lang="pug">
    #modal
        transition(name='modal-fade')
        .geral
            .geralModal(role='dialog', aria-labelledby='tituloModal', aria-describedby='modalDescription')
              header.cabecalhoModal
                slot(name='header')
                  p.titulo Resultado
                  button.fechar(type='button', @click='fecharModal', aria-label='Close modal')
                   | x
              section.corpo
                .input-group.mb-3
                    .input-group-prepend
                        span.input-group-text Categoria do carro:
                    input.form-control(type="text" :value="resultado.categoriaCarro" readonly)
                .input-group.mb-3
                    .input-group-prepend
                        span.input-group-text Nome da loja:
                    input.form-control(type="text" :value="resultado.nomeLoja" readonly)

                .input-group.mb-3
                    .input-group-prepend
                        span.input-group-text Valor total:
                    input.form-control(type="text" :value="resultado.valorTotal" readonly)
                br
                br
                button.btn.btn-danger.botaoFechar(@click="fecharModal") Fechar

</template>

<script>
export default {
    name: "modal",
    props: {
        resultado: Object
    },
    methods: {
        fecharModal(){
            this.$bus.$emit("fecharModal");
        }
    }
}
</script>

<style scoped>
    #modal{
        width: 100%;
        height: 100%;
        text-align: left;
        display:inline-block;
    }
    .geral {
        position: fixed;
        top: 0;
        bottom: 0;
        left: 0;
        right: 0;
        background-color: rgba(0, 0, 0, 0.3);
        display: flex;
        justify-content: center;
        align-items: center;
        z-index: 1000;
    }
    .cabecalhoModal {
        padding-top: 15px;
        padding-left: 15px;
        display: flex;
        color: white;
        background-color: #3B9C00;
        border-bottom: 1px solid #eeeeee;
        justify-content: space-between;
        padding-top: 1px;
        border-top-left-radius: 5px;
        border-top-right-radius: 5px;
    }

    .geralModal {
        background: #FFFFFF;
        box-shadow: 2px 2px 20px 1px;
        margin-top: 15px; 
        display: block !important;
        flex-direction: column;
        border-radius: 5px;
        display:inline-block;
    }
    .tituloModal {
        padding-top: 15px;
        padding-left: 15px;
        display: flex;
        color: white;
        border-bottom: 1px solid #eeeeee;
        justify-content: space-between;
        border-radius: 5px;
    }
    .corpo {
        position: relative;
        display: inline-block;
        margin: 20px;
        text-align: center;
        color: black;
        font-weight: bold;
    }
    .fechar {
        border: none;
        font-size: 20px;
        padding-right: 15px;
        cursor: pointer;
        background: transparent;
        color: white;
        font-weight: 600;
    }
    .titulo{
        font-size: 17px;
        margin-top: 15px;
        font-weight: 600;
    }

    .botaoFechar{
        float:right;
    }

</style>
