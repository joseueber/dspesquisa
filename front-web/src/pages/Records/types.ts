export type recordsResponse = {
    content: recordItem[];
    totalPages: number;   
}

export type recordItem = {
id: number;
name: string;
age: number;
moment: string;
gameTitle: string;
gamePlatform: Platform;
genreName: string;
}

export type Platform = 'XBOX' | 'PC' | 'PLAYSTATION'; 