<template lang="pug">
    #upload
        input(type="file" accept='text/plain' @change="verificarArquivo")
</template>

<script>
export default {
    name: "upload",
    data() {
        return {
            meses: [ 'Jan', 'Fev', 'Mar', 'Abr', 'Mai', 'Jun', 'Jul', 'Ago', 'Set', 'Out', 'Nov', 'Dez' ]
        }
    },
    methods: {
        verificarArquivo(event){
            const file = event.target.files[0];
            const reader = new FileReader();

            reader.onload = e => this.formatarTextoArquivo(e.target.result);
            reader.readAsText(file);
        },
        formatarTextoArquivo(textoArquivo) {
            let indiceTipoCarro = textoArquivo.indexOf(":");
            let indiceQuantidadePassageiros = parseInt(textoArquivo.indexOf(":", indiceTipoCarro + 1));
            let intervaloDatas = textoArquivo.substring(indiceQuantidadePassageiros + 1);
            this.formatarDatas(intervaloDatas);

            let textoFormatado = {
                tipoCarro: textoArquivo.substring(0, indiceTipoCarro),
                quantidadePassageiros: textoArquivo.substring(indiceTipoCarro + 1, indiceQuantidadePassageiros),
                intervaloData: this.formatarDatas(intervaloDatas)
            };

            this.$store.dispatch('armazenarTextoArquivo', textoFormatado);
        },
        formatarDatas(intervaloDatas) {      
            return intervaloDatas.split(", ");
        }

    }
}
</script>

<style scoped>
    #upload {
        margin-top: 20px;
    }
</style>
