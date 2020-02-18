<template>
    <div class="home container">
        <SearchEngine>

        </SearchEngine>
    </div>
</template>

<script>
    import SearchEngine from "@/components/SearchEngine";

    export default {
        name: 'Home',
        components: {SearchEngine},
        comments: {
            SearchEngine
        }
    }
</script>
