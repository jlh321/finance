import { Category } from '../category/category'

export interface Expense {
    id: number;
    amount: number;
    date: any;
    description: string,
    category: Category 
}