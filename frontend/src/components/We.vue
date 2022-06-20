<template>

    
    <div style="margin: 0 -15px 0 -15px;">
        <v-card-title>
            We
        </v-card-title>
        <v-card-text>
            <div v-if="editMode" style="margin-top:-20px;">
                <v-select
                        v-model="value"
                        :label="'We'"
                        :items="weList"
                        @change="change"
                ></v-select>
            </div>
            <div v-else style="margin-top:-20px;">
                We : {{ value }}
            </div>
        </v-card-text>
    </div>
    
</template>

<script>

    

    export default {
        name: 'We',
        components:{
            
        },
        props: {
            value: [Object, String, Number, Boolean, Array],
            editMode: Boolean,
            isNew: Boolean,
            offline: Boolean,
            inList: Boolean,
            label: String,
        },
        data: () => ({
            weList : [],
            
        }),
        created() {
            if(!this.value) {
                this.value = '';
            }
        },
        watch: {
            value(newVal) {
                this.$emit('input', newVal);
            },
        },

        methods: {
            edit() {
                this.editMode = true;
            },
            async add() {
                this.editMode = false;
                this.$emit('input', this.value);

                if(this.isNew){
                    this.$emit('add', this.value);
                } else {
                    this.$emit('edit', this.value);
                }
            },
            async remove(){
                this.editMode = false;
                this.isDeleted = true;

                this.$emit('input', this.value);
                this.$emit('delete', this.value);
            },
            change(){
                this.$emit('change', this.value);
            },
        }
    }
</script>

