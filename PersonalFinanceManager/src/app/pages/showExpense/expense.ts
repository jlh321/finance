import { Category } from '../category/category'

export interface Expense {
    id: number,
    amount: number,
    year:number,
    month:number,
    day:number
    description: string,
    category: Category 
}