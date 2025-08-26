
import React, { useState, useEffect } from 'react'
import Header from './components/Header.jsx'
import Guitar from './components/Guitar.jsx'
// import { db } from './data/db.js' // Change import to API call

function App() {

    // Function to get initial cart from localStorage ================================================
    /**
     * Initilize cart from localStorage
     * @returns {Array} cart 
     */
    const initialCart = () => {
        const localStorageCart = localStorage.getItem('cart')
        return localStorageCart ? JSON.parse(localStorageCart) : []
    }

    // Estates ================================================================================================
    const [data, setData] = useState([])
    const [cart, setCart] = useState(initialCart)

    const MIN_ITEMS = 1
    const MAX_ITEMS = 5

    // Load guitars from API =========================================================================
    useEffect(() => {
        fetch('http://localhost:8080/MusicShop/guitars')
            .then(response => response.json())
            .then(data => setData(data))
            .catch(err => console.error(err));
    }, [])

    // Sync cart with localStorage ==================================================================
    useEffect(() => {
        localStorage.setItem('cart', JSON.stringify(cart))
    }, [cart])

    // CART MANAGEMENT FUNCTIONS ==================================================================
    // Functions to ADD to cart -----------------------------------------------------
    function addToCart(item) {

        const itemExists = cart.findIndex((guitar) => guitar.id === item.id)
        if (itemExists >= 0) {
            if(cart[itemExists].quantity >= MAX_ITEMS)return
            const updatedCart = [...cart]
            updatedCart[itemExists].quantity++
            setCart(updatedCart)
        } else {
            item.quantity = 1
            setCart([...cart, item])
        }
    }

    // Function to REMOVE --------------------------------------------------------------
    function removeFromCart(id) {
        setCart(prevCart => prevCart.filter(guitar => guitar.id !== id))
    }

    // Function to INCREASE cart item quantity ---------------------------------------
    function increaseQuantity(id) {
        const updatedCart = cart.map(item => {
            if (item.id === id && item.quantity < MAX_ITEMS) {
                return {
                    ...item,
                    quantity: item.quantity + 1
                }
            }
            return item
        })
        setCart(updatedCart)
    }

    // Function to DECREASE cart item quantity ---------------------------------------
    function decreaseQuantity(id) {
        const updateCart = cart.map(item => {
            if (item.id === id && item.quantity > MIN_ITEMS) {
                return {
                    ...item,
                    quantity: item.quantity - 1
                }
            }
            return item
        })
        setCart(updateCart)
    }

    // Function to CLEAR the cart ----------------------------------------------------
    function clearCart() {
        setCart([])
    }

    // Render ==========================================================================
    return (
        <>
            <Header
                cart={cart}
                removeFromCart={removeFromCart}
                increaseQuantity={increaseQuantity}
                decreaseQuantity={decreaseQuantity}
                clearCart={clearCart}
            />

            <main className="container-xl mt-5">
                <h2 className="text-center">Nuestra Colección</h2>

                <div className='row mt-5'>


                    {data.map((guitar) => (
                        <Guitar
                            key={guitar.id}
                            guitar={guitar}
                            addToCart={addToCart}
                        />
                    ))}
                </div>
            </main>


            <footer className="bg-dark mt-5 py-5">
                <div className="container-xl">
                    <p className="text-white text-center fs-4 mt-4 m-md-0">GuitarLA - Todos los derechos Reservados</p>
                </div>
            </footer>

        </>
    )
}

export default App
