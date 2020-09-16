import { Category } from '../category/category'

export interface Expense {
    id: string,
    amount: number,
    year:number,
    month:number,
    day:number
    description: string,
    category: Category 
}