import { Account } from './Account'

export interface AccountTransaction {
    id: string,
    amount: number,
    year:number,
    month:number,
    day:number
    description: string,
    account: Account 
}