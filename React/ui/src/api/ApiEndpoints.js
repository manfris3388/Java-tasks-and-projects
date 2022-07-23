import HTTP from "./AxiosConfig";

const getCharts = () => HTTP.get("/charts")

const createProduct = (productData) => HTTP.post("/charts", productData)
