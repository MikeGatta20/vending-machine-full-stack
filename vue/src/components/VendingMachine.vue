<template>
    <div class="flex-box-machine">
        <div class="vending_machine">
            
            <div class="shelf">
                <!--List of items--> 
                <VendingItem v-for="item in vendingItems" v-bind:key="item.itemId" v-bind:itemId="item.itemId"/>
            </div>
        </div>
    </div>

</template>

<script>
import VendingItem from './VendingItem.vue';
import VendingMachineService from '../services/VendingMachineService';

export default {
    components: {
        VendingItem
    },
    data() {
        return {
            vendingItems: []
        }
    }, 
    created() {
        VendingMachineService.getAllVendingItems().then((response) => {
            if (response.status == 200){
                console.log(response.data)
                this.vendingItems = response.data;
            }
        }).catch((error) => {
            console.log(error); 
        })
    }
}
</script>


<style scoped>

.flex-box-machine {
    width: 100vw;
    display: flex;
    justify-content: center;
    align-items: center; 
}

.vending_machine{
    width: 800px;
    height: 600px;
    background-color: darkgray; 
    padding: 20px;
}

.shelf {
    background-color: whitesmoke;
    width: 600px;
    height: 90%; 
    padding: 20px;
    display: flex;
  


}

</style>
