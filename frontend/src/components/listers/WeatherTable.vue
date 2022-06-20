<template>
    <div>
        <v-data-table

    <v-data-table
            :headers="headers"
            :items="values"
            :items="weather"
            :items-per-page="5"
            class="elevation-1"
        ></v-data-table>

        <v-col style="margin-bottom:40px;">
            <div class="text-center">
                <v-dialog
                v-model="openDialog"
                width="332.5"
                fullscreen
                hide-overlay
                transition="dialog-bottom-transition"
                >
                <template v-slot:activator="{ on, attrs }">
                    <v-fab-transition>
                        <v-btn
                            color="blue"
                            fab
                            dark
                            large
                            style="position:absolute; bottom: 5%; right: 2%; z-index:99"
                        >
                            <v-icon v-bind="attrs" v-on="on">mdi-plus</v-icon>
                        </v-btn>
                    </v-fab-transition>
                </template>
    ></v-data-table>

                <Weather :offline="offline" class="video-card" :isNew="true" :editMode="true" v-model="newValue" @add="append" v-if="tick"/>
                
                <v-btn
                    style="postition:absolute; top:2%; right:2%"
                    @click="closeDialog()"
                    depressed 
                    icon 
                    absolute
                >
                        <v-icon>mdi-close</v-icon>
                </v-btn>
                </v-dialog>
            </div>
        </v-col>
    </div>
</template>

<script>

  export default {
    name: 'WeatherManager',
    components: {
        Weather,
    },
    props: {
      offline: Boolean,
      editMode: Boolean,
      isNew: Boolean
    },
    data: () => ({
        values: [],
        headers: [
            { text: "id", value: "id" },
            { text: "temperature", value: "temperature" },
            { text: "location", value: "location" },
            { text: "key", value: "key" },
        ],
        weather : [],
        newValue: {},
        tick : true,
        openDialog : false,
    }),
    async created() {
      if(this.offline){
          if(!this.values) this.values = [];
          return;
      } 

      var temp = await axios.get(axios.fixUrl('/weathers'))
      temp.data._embedded.orders.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])
      this.values = temp.data._embedded.weathers;

    },
    methods: {
        closeDialog(){
            this.openDialog = false
    export default {
        name: 'Weather',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        append(value){
            this.tick = false
            this.newValue = {}
            this.values.push(value)
            
            this.$emit('input', this.values);

            this.$nextTick(function(){
                this.tick=true
            })
        data: () => ({
            headers: [
                { 
                    text: "humidity", 
                    value: "humidity" 
                },
                { 
                    text: "wind", 
                    value: "wind" 
                },
                { 
                    text: "temperature", 
                    value: "temperature" 
                },
            ],
            weather : [],
        }),
        async created() {
            if(!this.value) this.value = [];
        },
        methods: {
        }
    }
  }
</script>

