<template>

<v-data-table
    :headers="headers"
    :items="personalizedRecommendation"
    :items-per-page="5"
    class="elevation-1"
  ></v-data-table>

</template>

<script>
  const axios = require('axios').default;

  export default {
    name: 'PersonalizedRecommendation',
    props: {
      value: Object,
      editMode: Boolean,
      isNew: Boolean
    },
    data: () => ({
        headers: [
            { text: "id", value: "id" },
            { text: "attireId", value: "attireId" },
            { text: "foodId", value: "foodId" },
            { text: "activityId", value: "activityId" },
            { text: "location", value: "location" },
            { text: "city", value: "city" },
            { text: "weather", value: "weather" },
            { text: "key", value: "key" },
        ],
        personalizedRecommendation : [],
    }),
    async created() {
      var temp = await axios.get(axios.backend + '/personalizedrecommendations')

      this.personalizedRecommendation = temp.data._embedded.personalizedrecommendations;

    },
    methods: {
    }
  }
</script>

