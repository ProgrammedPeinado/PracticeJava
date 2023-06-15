import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FoodComponent } from './food/food/food.component';
import { SingleFoodComponent } from './single-food/single-food.component';
import { ListComponent } from './list/list.component';


const routes: Routes = [
  {path: '', component:FoodComponent},
  {path:'foods/:id', component:SingleFoodComponent},
  {path: 'list', component: ListComponent},
  {path: '', redirectTo: 'list', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }