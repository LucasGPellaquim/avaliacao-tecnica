<template lang="pug">
    #home
        h1.title Bem-vindo a avaliação para Desenvolvedor Java!
        locacao
        .rodape © 2019 Lemaf/Lucas Gonçalves Pellaquim All Rights Reserved
</template>

<script>
import Locacao from "../components/home/Locacao";

export default {
    name: "home",
    components: { Locacao }
}
</script>

<style scoped>
    #home {
        margin: 50px;
        color: #E9E9E9;
    }
    .title {
        text-align: center;
        color: #fff;
        padding: 10px;
        border-radius: 5px;
        background-color: #3B9C00;
    }
    .rodape{
        text-align: center;
        color: black;
        font-size: 12px;
        margin-top: 50px;
    }
</style>
