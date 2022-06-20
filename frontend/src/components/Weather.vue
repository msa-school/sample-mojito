<template>

    <v-card style="width:300px;" outlined>
        <template slot="progress">
            <v-progress-linear
                    color="deep-purple"
                    height="10"
                    indeterminate
            ></v-progress-linear>
        </template>

    <v-card style="width:300px;" outlined>
        <v-card-title>
        <v-img
            style="width:290px; height:150px; border-radius:10px; position:relative; margin-left:5px; top:5px;"
            :style="editMode ? 'cursor:pointer;':''"
            :src="value.photo ? value.photo:'https://cdn.vuetifyjs.com/images/cards/cooking.png'"
            @click="selectFile()"
        ></v-img>

        <v-card-title v-if="value._links">
            Weather # {{value._links.self.href.split("/")[value._links.self.href.split("/").length - 1]}}
        </v-card-title >
        <v-card-title v-else>
            Weather
        </v-card-title>
        </v-card-title >

        <v-card-text>
            <Number label="Humidity" v-model="value.humidity" :editMode="editMode"/>
            <Number label="Wind" v-model="value.wind" :editMode="editMode"/>

            <div>
                <String label="Temperature" v-model="value.temperature" :editMode="editMode"/>
                <String label="Weather" v-model="value.weather" :editMode="editMode"/>
            </div>
            <div>
                <String label="Location" v-model="value.location" :editMode="editMode"/>
                <String label="City" v-model="value.city" :editMode="editMode"/>
            </div>
            <div>
                <String label="Key" v-model="value.key" :editMode="editMode"/>
            </div>
        </v-card-text>

        <v-card-actions v-if="inList">
        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="edit"
                    v-if="!editMode"
            >
                Edit
            </v-btn>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="add"
                    @click="save"
                    v-else
            >
                Add
                Save
            </v-btn>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="remove"
                    v-if="!editMode"
            >
                Delete
            </v-btn>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="editMode = false"
                    v-if="editMode && !isNew"
            >
                Cancel
            </v-btn>
        </v-card-actions>
        <v-card-actions>
            <v-spacer></v-spacer>                        
        </v-card-actions>
    </v-card>

</template>

<script>
    const axios = require('axios').default;

    import String from './primitives/String.vue';
    import Number from './primitives/Number.vue';
    import Boolean from './primitives/Boolean.vue';
    import Date from './primitives/Date.vue';

    
    export default {
        name: 'Weather',
        components:{
            String,
            Number,
            Boolean,
            Date,
        },
        props: {
            value: [Object, String, Number, Boolean, Array],
            editMode: Boolean,
            isNew: Boolean,
            offline: Boolean,
            inList: Boolean,
            label: String,
            offline: Boolean
        },
        data: () => ({
        }),
        created() {
        created(){
            if(!this.value) {
                this.value = {};
            }
            if(typeof this.value === 'object') {
                if(!('humidity' in this.value)) {
                    this.value.humidity = null;
                if(!('temperature' in this.value)) {
                    this.value.temperature = null;
                if(!('weather' in this.value)) {
                    this.value.weather = null;
                }
                if(!('wind' in this.value)) {
                    this.value.wind = null;
                if(!('location' in this.value)) {
                    this.value.location = null;
                if(!('city' in this.value)) {
                    this.value.city = null;
                }
            }
        },
        watch: {
            value(newVal) {
                this.$emit('input', newVal);
            },
                if(!('key' in this.value)) {
                    this.value.key = null;
                }
            }            
        },

        methods: {
            selectFile(){
            if(this.editMode == false) {
                return false;
            }
                var me = this
                var input = document.createElement("input");
                input.type = "file";
                input.accept = "image/*";
                input.id = "uploadInput";
                
                input.click();
                input.onchange = function (event) {
                    var file = event.target.files[0]
                    var reader = new FileReader();

                    reader.onload = function () {
                        var result = reader.result;
                        me.imageUrl = result;
                        me.value.photo = result;
                        
                    };
                    reader.readAsDataURL( file );
                };
            },
            edit() {
                this.editMode = true;
            },
            async add() {
                this.editMode = false;
                this.$emit('input', this.value);
            async save(){
                try {
                    var temp = null;

                    if(!this.offline) {
                        if(this.isNew) {
                            temp = await axios.post(axios.fixUrl('/weathers'), this.value)
                        } else {
                            temp = await axios.put(axios.fixUrl(this.value._links.self.href), this.value)
                        }
                    }

                    if(this.value!=null) {
                        for(var k in temp.data) this.value[k]=temp.data[k];
                    } else {
                        this.value = temp.data;
                    }

                if(this.isNew){
                    this.$emit('add', this.value);
                } else {
                    this.$emit('edit', this.value);
                    this.editMode = false;
                    this.$emit('input', this.value);

                    if (this.isNew) {
                        this.$emit('add', this.value);
                    } else {
                        this.$emit('edit', this.value);
                    }

                } catch(e) {
                    alert(e.message)
                }
                location.reload()
            },
            async remove(){
                this.editMode = false;
                this.isDeleted = true;
                try {
                    if (!this.offline) {
                        await axios.delete(axios.fixUrl(this.value._links.self.href))
                    }

                this.$emit('input', this.value);
                this.$emit('delete', this.value);
                    this.editMode = false;
                    this.isDeleted = true;

                    this.$emit('input', this.value);
                    this.$emit('delete', this.value);

                } catch(e) {
                    alert(e.message)
                }
            },
            change(){
                this.$emit('change', this.value);
                this.$emit('input', this.value);
            },
        }
        },
    }
</script>

